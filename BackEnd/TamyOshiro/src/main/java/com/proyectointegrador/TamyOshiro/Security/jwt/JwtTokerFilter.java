/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegrador.TamyOshiro.Security.jwt;

import com.proyectointegrador.TamyOshiro.Security.Service.UserDetailsImpl;
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author tamy_
 */
public class JwtTokerFilter extends OncePerRequestFilter{
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserDetailsImpl userDailsServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(request);
            if(token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDerails = userDailsServiceImpl.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth =new UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } 
        } catch (Exception e){
            logger.error("Falló el metodo doFilterInternal");
        } catch (Object ex) {
            java.util.logging.Logger.getLogger(JwtTokerFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        filterChain.doFilter(request, response);
    }
    
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorizarion");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer"), "");
        return null;
    }
}
