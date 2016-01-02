<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ attribute name="materialList" required="true" type="java.util.List" %><%@ taglib prefix="material" tagdir="/WEB-INF/tags/material" %><spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/><spring:url value="/resources/img/add_btn.png" var="add_btn"/><spring:url value="/resources/img/delete_btn.png" var="delete_btn"/><spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/><c:forEach var="material" items="${materialList}">    <li>        <div class="item">            <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">                ${material.name}                ${material.id}            <div class="add_delete_wrapper">                <form action="${pageContext.request.contextPath}/projects/removeMaterial" method="post">                    <input type="hidden" name="projectId" value="${projectId}">                    <input type="hidden" name="id" value="${material.id}">                    <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">                </form>                <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">                <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}" alt="show_update_forms">            </div>            <material:updateMaterial materialData="${material}"/>        </div>    </li></c:forEach>