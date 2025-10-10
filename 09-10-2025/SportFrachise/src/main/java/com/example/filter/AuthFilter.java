package com.example.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Service.CricketService;
import com.example.Util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFilter extends OncePerRequestFilter {
	@Autowired
	JwtUtil jw;
    @Autowired
    CricketService cs;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authheader=request.getHeader("Authorization");
		String token=null;
		String username=null;
		if(authheader!=null&&authheader.startsWith("Bearer "))
		{
			token=authheader.substring(7);
			username=jw.extractUsername(token);
		}
		if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails ud=cs.loadUserByUsername(username);
			if(JwtUtil.validateToken(ud,username,token))
			{
			UsernamePasswordAuthenticationToken upat=	new UsernamePasswordAuthenticationToken(ud,null,ud.getAuthorities());
			
			
			SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}
		filterChain.doFilter(request, response);
	}

}
