<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="co.yedam.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%
	List<ProdVO> list = (List<ProdVO>) request.getAttribute("plist");
%>

	<c:forEach var="vo" items="${plist}">
        <div class="col mb-5">
           <div class="card h-100">
               <!-- Product image-->
               <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
               <!-- Product details-->
               <div class="card-body p-4">
                   <div class="text-center">
                       <!-- Product name-->
                       <h5 class="fw-bolder">${vo.prodNm}"</h5>
                       <!-- Product reviews-->
                       <div class="d-flex justify-content-center small text-warning mb-2">
                           <div class="bi-star-fill"></div>
                           <div class="bi-star-fill"></div>
                           <div class="bi-star-fill"></div>
                           <div class="bi-star-fill"></div>
                           <div class="bi-star-fill"></div>
                       </div>
                       <!-- Product price-->
                       $40.00
                   </div>
               </div>
               </div>
               </div>
    </c:forEach>