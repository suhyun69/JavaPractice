package com.example.demo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@Order(1)
public class SecondSampleFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("SecondSampleFilter doFilterInternal()");

        // 다음 filter 실행 전 처리(prehandle)

        // 다음 filter-chain에 대한 실행(filter-chain의 마지막에는 Dispatcher servlet 실행)
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("SecondSampleFilter destroy()");
        super.destroy();;
    }
}
