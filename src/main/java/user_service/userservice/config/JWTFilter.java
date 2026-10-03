// package user_service.userservice.config;

// import java.io.IOException;

// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component 
// public class JWTFilter extends OncePerRequestFilter {

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
        
//         String BearerToken = request.getHeader("Authorization");
//         if( BearerToken == null || !BearerToken.startsWith("Bearer"))
//             throw new IllegalArgumentException("Invalid token");

//         String token = BearerToken.substring(7);
//         if(token == null || token.isEmpty())
//             throw new IllegalArgumentException("Token is empty");



//         filterChain.doFilter(request, response);
//     }
// }
