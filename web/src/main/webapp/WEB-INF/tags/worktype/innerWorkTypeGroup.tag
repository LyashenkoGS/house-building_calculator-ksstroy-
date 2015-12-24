<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ attribute name="workTypeGroupchikList" required="true" type="java.util.List" %><%@ taglib prefix="worktype" tagdir="/WEB-INF/tags/worktype" %><spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/><spring:url value="/resources/img/add_btn.png" var="add_btn"/><spring:url value="/resources/img/delete_btn.png" var="delete_btn"/><c:forEach var="innerWorkTypeGroups" items="${workTypeGroupchikList}">    <ul>        <div class="item">            <img class="clickableIcon" src="${arrow_drop_down}" alt="Arrow">                its for${innerWorkTypeGroups.name}            <div class="add_delete_wrapper">                <div class="delete_btn">                    <form action="${pageContext.request.contextPath}/workType/removeWorkTypeGroup" method="post">                        <input type="hidden" name="id" value="${innerWorkTypeGroups.id}">                        <input type="hidden" name="projectId" value="${projectId}">                        <input type="image" src="${delete_btn}" alt="Delete">                    </form>                </div>                <div class="add_btn">                    <img src="${add_btn}" alt="Add">                </div>            </div>        </div>        <worktype:addInnerWorkTypeGroup innerWorkTypeGroup="${innerWorkTypeGroups}"/>        <worktype:addWorkTypes workTypeGroup="${innerWorkTypeGroups}"/>        <ul>            <worktype:workTypes workTypchikList="${innerWorkTypeGroups.workTypesData}"/>        </ul>    </ul></c:forEach>