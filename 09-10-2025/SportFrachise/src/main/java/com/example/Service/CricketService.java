package com.example.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Model.CricketPlayer;
import com.example.Repository.CricketRepository;

@Service
@Primary
@Component
public class CricketService implements UserDetailsService {
	@Autowired
    CricketRepository cs;
	public Object Saveplayers(CricketPlayer cp)
	{
		return cs.save(cp);
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return cs.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
	}
	
	
        
}
