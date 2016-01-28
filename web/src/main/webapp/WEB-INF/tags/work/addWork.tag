<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="workGroup" required="true" type="ua.ksstroy.logic.work.WorkGroupData" %>
<%--<%@attribute name="workType" required="true" type="ua.ksstroy.logic.worktype.WorkTypeGroupData" %>--%>
<%@attribute name="zone" required="true" type="ua.ksstroy.logic.zonegroup.ZoneHierarchyData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">Add Work</div>
    <form action="${pageContext.request.contextPath}/projects/addWork" method="post">
        <input type="hidden" name="parentId" value="${workGroup.id}">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tr>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" placeholder="Enter name"></td>
            </tr>
            <%--<tr>
                <td>planedCost:</td>
                <td><input type="text" name="planedCost" placeholder="Enter planedCost"></td>
            </tr>--%>

            <%--<tr>
                <td>perspectiveCost:</td>
                <td><input type="text" name="perspectiveCost" placeholder="Enter perspectiveCost"></td>
            </tr>
            <tr>
                <td>closedCost:</td>
                <td><input type="text" name="closedCost" placeholder="Enter closedCost"></td>
            </tr>
            <tr>
                <td>dealCost:</td>
                <td><input type="text" name="dealCost" placeholder="Enter dealCost"></td>
            </tr>--%>
            <%--<tr>
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
            </tr>--%>

            <tr>
                <td>zone:</td>
                <td>
                    <form method="post">
                        <select name="zoneId">
                            <c:forEach var="zone" items="${zone.groups}">

                                <%--<option value="1">${zone.name}</option>--%>

                                <c:forEach var="zoneData" items="${zone.zones}">
                                    <option value="${zoneData.id}">${zoneData.name}</option>
                                </c:forEach>

                            </c:forEach>
                        </select>
                    </form>
                </td>
            </tr>

            </tbody>
        </table>
        <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
    </form>
</div>