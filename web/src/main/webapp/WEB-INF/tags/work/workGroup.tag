<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="workGroup" required="true" type="ua.ksstroy.logic.work.WorkGroupData" %>
<%--<%@attribute name="workType" required="true" type="ua.ksstroy.logic.worktype.WorkTypeGroupData" %>--%>
<%--<%@attribute name="zone" required="true" type="ua.ksstroy.logic.zonegroup.ZoneHierarchyData" %>--%>
<%@ taglib prefix="work" tagdir="/WEB-INF/tags/work" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>


<c:if test="${workGroup.name ne 'root_group'}">
    <div class="item">
        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
            ${workGroup.name}
        <div class="add_delete_wrapper">
            <form action="${pageContext.request.contextPath}/projects/removeWorkGroup" method="post">
                <input type="hidden" name="id" value="${workGroup.id}">
                <input type="hidden" name="projectId" value="${projectId}">
                <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
            </form>

            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
            <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}" alt="show_update_forms">
        </div>
        <work:addWork workGroup="${workGroup}" zone="${zone}"/>
        <work:addWorkGroup innerWorkGroup="${workGroup}" workType="${workType}"/>
        <work:updateWorkGroup workGroup="${workGroup}"/>
    </div>
</c:if>