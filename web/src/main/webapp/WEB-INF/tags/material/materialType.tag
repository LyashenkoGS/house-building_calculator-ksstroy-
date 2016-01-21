<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ attribute name="materialList" required="true" type="java.util.List" %><%@ taglib prefix="material" tagdir="/WEB-INF/tags/material" %><spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/><spring:url value="/resources/img/purchase_material.png" var="purchase"/><spring:url value="/resources/img/delete_btn.png" var="delete_btn"/><spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/><c:forEach var="materialType" items="${materialList}">    <li>        <div class="purchase" >            <div class="item">                <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">                    ${materialType.name}                <div class="add_delete_wrapper">                    <form action="${pageContext.request.contextPath}/projects/removeMaterialType" method="post">                        <input type="hidden" name="projectId" value="${projectId}">                        <input type="hidden" name="id" value="${materialType.id}">                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">                    </form>                    <img class="purchase_material clickableIcon" src="${purchase}" alt="Purchase">                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"                         alt="show_update_forms">                </div>                <material:updateMaterialType materialTypeData="${materialType}"/>            </div>            <material:purchase_material materialTypeData="${materialType}"/>        </div>    </li></c:forEach>