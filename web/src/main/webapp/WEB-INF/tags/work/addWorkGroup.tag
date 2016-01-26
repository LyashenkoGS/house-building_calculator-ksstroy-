<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="innerWorkGroup" required="true" type="ua.ksstroy.logic.work.WorkGroupData" %>
<%@attribute name="workType" required="true" type="ua.ksstroy.logic.worktype.WorkTypeGroupData" %>
<%@ taglib prefix="work" tagdir="/WEB-INF/tags/work" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">Add Project Work</div>
    <form action="${pageContext.request.contextPath}/projects/addInnerWorkGroup" method="post">
        <input type="hidden" name="parentId" value="${innerWorkGroup.id}">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tbody>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" placeholder="Enter name"></td>
            </tr>
            <td>work type:</td>
            <td>
                <form method="post">
                    <select name="workTypeId">
                        <c:forEach var="workType" items="${workType.workTypeGroupsData}">

                            <c:forEach var="wortTypeData" items="${workType.workTypesData}">
                                <option value="${wortTypeData.id}">${wortTypeData.name}</option>
                            </c:forEach>

                        </c:forEach>
                    </select>
                </form>
            </td>
            </tbody>
        </table>
        <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
    </form>
</div>