<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="workList" required="true" type="java.util.List" %>

<%@ taglib prefix="work" tagdir="/WEB-INF/tags/work" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>

<c:forEach var="work" items="${workList}">
    <ul class ="group">
    <li>
        <div class="item">
            <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                <b>${work.name}</b><br>
                planed_cost: ${work.planedCost}<br>
                zone: zone_name<br>
                work_type: work_tpe name
            <div class="add_delete_wrapper">
                <form action="${pageContext.request.contextPath}/projects/removeWork" method="post">
                    <input type="hidden" name="projectId" value="${projectId}">
                    <input type="hidden" name="id" value="${work.id}">
                    <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
                </form>
                <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}" alt="show_update_forms">
            </div>
            <%--<work:updateWork work="${work}"/>--%>
            <%--<work:addCover work="${work}"/>
            <work:addAdjustment work="${work}"/>--%>
        </div>
        <ul class ="subgroup">
            <%--<work:covers coverList="${work.allCovers}"/>
            <work:adjustment adjustmentList="${work.adjustments}"/>
            <work:zones zoneList="${work.workZones}"/>--%>
        </ul>
    </ul>
    </li>
</c:forEach>