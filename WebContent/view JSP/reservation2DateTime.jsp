<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${requestScope.datetime}" var="option">
  <option><c:out value="${option}" />
</c:forEach>