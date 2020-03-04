<%@ page import="java.util.List,bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:forEach var="node" items="${node.children}">
	<ul>
		<c:choose>
			<c:when test="${empty( node.children ) }">
				<li
					data-jstree='{"icon":"glyphicon glyphicon-file", "valid_children" : []}'>${node.fileName}
			</c:when>
			<c:otherwise>
				<li>${node.fileName}
			</c:otherwise>
		</c:choose>
		<c:set var="node" value="${node}" scope="request" />
		<jsp:include page="filesNode.jsp" />
	</ul>
</c:forEach>



