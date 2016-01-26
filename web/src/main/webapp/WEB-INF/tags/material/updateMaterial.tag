<%@attribute name="material" type="ua.ksstroy.logic.material.MaterialData" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">Update Material</div>
    <form action="${pageContext.request.contextPath}/projects/updateMaterial" method="post">
        <input type="hidden" name="id" value="${material.id}">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tbody>
            <tr>
                <td>unitsPerWorkZoneMeasure:</td>
                <td><input type="text" name="name" value="${material.unitsPerWorkZoneMeasure}"></td>
            </tr>
            <tr>
                <td>planedCost:</td>
                <td><input type="text" name="description" value="${material.planedCost}"></td>
            </tr>
       <%--     <tr>
                <td>dealCost:</td>
                <td><input type="text" name="pricePerUnit" value="${material.dealCost}"></td>
            </tr>
            <tr>
                <td>closedCost:</td>
                <td><input type="text" name="unitName" value="${material.closedCost}"></td>
            </tr>--%>
            </tbody>
        </table>
        <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
    </form>
</div>