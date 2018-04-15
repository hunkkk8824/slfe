//package com.selfwork.intelligence.config;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    public static final String DEFAULT_ERROR_VIEW = "errorpage/error";
//
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        return mav;
//    }
//
//}