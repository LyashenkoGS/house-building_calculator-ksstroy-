<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %><%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ attribute name="materialData" required="true" type="ua.ksstroy.logic.material.MaterialData" %><spring:url value="/resources/img/done_btn.png" var="done_btn"/><div class="controller">    <div class="controller_name">Update Material</div>    <form action="${pageContext.request.contextPath}/material/updateMaterial" method="post">        <input type="hidden" name="id" value="${materialData.id}">        <input type="hidden" name="projectId" value="${projectId}">        <table>            <tbody>            <tr>                <td>name:</td>                <td><input type="text" name="name" value="${materialData.name}"></td>            </tr>            <tr>                <td>description:</td>                <td><input type="text" name="description" value="${materialData.description}"></td>            </tr>            <tr>                <td>measure:</td>                <td><input type="text" name="measure" value="${materialData.measure}"></td>            </tr>            <tr>                <td>size:</td>                <td><input type="text" name="size" value="${materialData.size}"></td>            </tr>            <tr>                <td>planed cost:</td>                <td><input type="text" name="planedCost" value="${materialData.planedCost}"></td>            </tr>            <tr>                <td>deal cost:</td>                <td><input type="text" name="dealCost" value="${materialData.dealCost}"></td>            </tr>            <tr>                <td>closed cost:</td>                <td><input type="text" name="closedCost" value="${materialData.closedCost}"></td>            </tr>            </tbody>        </table>        <input class="accepth_changes_btn" type="image" src="${done_btn}">    </form></div>