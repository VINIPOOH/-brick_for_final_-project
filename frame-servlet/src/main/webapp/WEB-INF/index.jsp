<%--<!DOCTYPE html>--%>
<%--<html xmlns:th="http://www.thymeleaf.org">--%>
<%--<head>--%>
<%--    <div th:include="~{layout/header.jsp::head_base_data}"></div>--%>
<%--    <title th:text="#{homepage.title}"></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div th:include="~{layout/header.jsp::header}"></div>--%>
<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-md-6">--%>
<%--            <div class="panel panel-default">--%>
<%--                <div class="panel-heading">--%>
<%--                    <h3 class="panel-heading" th:text="#{homepage.form.header}"></h3>--%>
<%--                </div>--%>
<%--                <div class="panel-body">--%>
<%--                    <form  id="form" class="form" method="post" th:action="@{/home}" th:object="${deliveryInfoRequestDto}" >--%>
<%--                        <div class="alert alert-danger" role="alert" th:if="${incorrectWeightInput}">--%>
<%--                            <p th:text="#{homepage.form.weight.incorect}"></p>--%>
<%--                        </div>--%>
<%--                        <div class="alert alert-danger" role="alert" th:if="${unsupportableWeightFactorException}">--%>
<%--                            <p th:text="#{registrationpage.form.weight.wrong}"></p>--%>
<%--                        </div>--%>
<%--                        <div class="alert alert-danger" role="alert" th:if="${noSuchWayException}">--%>
<%--                            <p  th:text="#{registrationpage.form.way.wrong}"></p>--%>
<%--                        </div>--%>

<%--                        <div class="form-group" >--%>
<%--                            <input type="number" class="form-control" id="deliveryWeight" name="deliveryWeight" th:placeholder="#{homepage.form.weight}" >--%>
<%--                        </div>--%>
<%--                        <label th:text="#{homepage.form.label.locality_sand}"></label>--%>
<%--                        <select th:field="*{localitySandID}" form="form" class="form-control">--%>
<%--                            <option th:if="${#locale.getISO3Language()=='rus'}" th:each="locality :${localityList}" th:value="${locality.id}" th:text="${locality.nameRu}" th:id= "localitySandID" th:name="localitySandID"></option>--%>
<%--                            <option th:if="${#locale.getISO3Language()=='eng'}" th:each="locality :${localityList}" th:value="${locality.id}" th:text="${locality.nameEn}" th:id="localitySandID" th:name="localitySandID"></option>--%>
<%--                        </select>--%>
<%--                        <label th:text="#{homepage.form.label.locality_get}"></label>--%>
<%--                        <select th:field="*{localityGetID}" form="form" class="form-control">--%>
<%--                            <option th:if="${#locale.getISO3Language()=='rus'}" th:each="locality :${localityList}" th:value="${locality.id}" th:text="${locality.nameRu}" th:id="localityGetID" th:name="localityGetID"></option>--%>
<%--                            <option th:if="${#locale.getISO3Language()=='eng'}" th:each="locality :${localityList}" th:value="${locality.id}" th:text="${locality.nameEn}" th:id="localityGetID" th:name="localityGetID"></option>--%>
<%--                        </select>--%>
<%--                        <p1></p1>--%>
<%--                        <button class="btn btn-success" type="submit" th:text="#{homepage.form.button}"></button>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div th:if="${deliveryCostAndTimeDto!=null}" class="col-md-6 container-fluid">--%>
<%--            <table class="table" style="--%>
<%--        width: 40%;--%>
<%--        margin: 0 auto;--%>
<%--        background:  #0c5460;--%>
<%--        border-radius: 10px;--%>
<%--        color: white;--%>
<%--        ">--%>
<%--                <tbody>--%>
<%--                <tr>--%>
<%--                    <td><span th:text="#{homepage.paragraf.price}">  </span></td>--%>
<%--                    <td><span th:text="${deliveryCostAndTimeDto.costInCents}"> </span></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td><span th:text="#{homepage.paragraf.time}">  </span></td>--%>
<%--                    <td><span th:text="${deliveryCostAndTimeDto.timeOnWayInHours}"> </span></td>--%>
<%--                </tr>--%>
<%--                </tbody>--%>
<%--            </table>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
dfffdfdfdfdfdfdfdfd