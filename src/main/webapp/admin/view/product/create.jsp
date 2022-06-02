<%@ page import="java.util.HashMap" %>
<%@ page import="thang.t2009m1.t2009m1java.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: DUCTHANG
  Date: 6/1/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");%>
<%
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        product = new Product();
    }
    if (errors != null) {
        for (String i : errors.keySet()) {
            System.out.println(errors.get(i));
        }
    }
%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/admin/includes/head.jsp"/>

<body>

<!--*******************
    Preloader start
********************-->
<div id="preloader">
    <div class="sk-three-bounce">
        <div class="sk-child sk-bounce1"></div>
        <div class="sk-child sk-bounce2"></div>
        <div class="sk-child sk-bounce3"></div>
    </div>
</div>
<!--*******************
    Preloader end
********************-->


<!--**********************************
    Main wrapper start
***********************************-->
<div id="main-wrapper">

    <!--**********************************
        Nav header start
    ***********************************-->
    <div class="nav-header">
        <a href="index.html" class="brand-logo">
            <img class="logo-abbr" src="/admin/images/logo.png" alt="">
            <img class="logo-compact" src="/admin/images/logo-text.png" alt="">
            <img class="brand-title" src="/admin/images/logo-text.png" alt="">
        </a>

        <div class="nav-control">
            <div class="hamburger">
                <span class="line"></span><span class="line"></span><span class="line"></span>
            </div>
        </div>
    </div>
    <!--**********************************
        Nav header end
    ***********************************-->

    <!--**********************************
        Header start
    ***********************************-->
    <jsp:include page="/admin/includes/header.jsp"/>
    <!--**********************************
        Header end ti-comment-alt
    ***********************************-->

    <!--**********************************
        Sidebar start
    ***********************************-->
    <jsp:include page="/admin/includes/main-sidebar.jsp"/>
    <!--**********************************
        Sidebar end
    ***********************************-->

    <!--**********************************
        Content body start
    ***********************************-->
    <div class="content-body">
        <div class="container-fluid">

            <!-- row -->
            <div class="row">
                <div class="col-xl-12 col-xxl-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Create Product</h4>
                        </div>
                        <div class="card-body">
                            <div class="basic-form">
                                <form>
                                    <div class="form-row">
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" value="<%=product.getName()%>"
                                                   placeholder="Enter product name"
                                                   name="name">
                                            <%
                                                if (errors.containsKey("name")) {
                                            %>
                                            <p class="valid">* <%=errors.get("name")%>
                                            </p>
                                            <%}%>
                                        </div>
                                        <div class="col-sm-6 mt-2 mt-sm-0">
                                            <label>Description</label>
                                            <input type="text" class="form-control"
                                                   value="<%=product.getDescription()%>"
                                                   placeholder="Enter description" name="description">
                                            <%
                                                if (errors.containsKey("description")) {
                                            %>
                                            <p class="valid">* <%=errors.get("description")%>
                                            </p>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-sm-6">
                                            <label>Detail</label>
                                            <input type="text" class="form-control" value="<%=product.getDetail()%>"
                                                   placeholder="Enter detail"
                                                   name="detail">
                                        </div>
                                        <div class="col-sm-6 mt-2 mt-sm-0">
                                            <label>Price</label>
                                            <input type="number" class="form-control" value="<%=product.getPrice()%>"
                                                   placeholder="Enter price"
                                                   name="price">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-sm-6">
                                            <label>Thumbnail</label>
                                            <input type="text" class="form-control" value="<%=product.getThumbnail()%>"
                                                   placeholder="Enter thumbnail"
                                                   name="thumbnail">
                                            <%
                                                if (errors.containsKey("thumbnail")) {
                                            %>
                                            <p class="valid"><%=errors.get("name")%>
                                            </p>
                                            <%}%>
                                        </div>
                                        <div class="col-sm-6 mt-2 mt-sm-0">
                                            <label>Manufacture email</label>
                                            <input type="text" class="form-control"
                                                   value="<%=product.getManufactureEmail()%>"
                                                   placeholder="Enter manufacture email" name="manufactureEmail">
                                            <%
                                                if (errors.containsKey("email")) {
                                            %>
                                            <p class="valid">* <%=errors.get("email")%>
                                            </p>
                                            <%}%>
                                            <%
                                                if (errors.containsKey("emailValid")) {
                                            %>
                                            <p class="valid">* <%=errors.get("emailValid")%>
                                            </p>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-sm-12">
                                            <label>Manufacture phone</label>
                                            <input type="text" class="form-control"
                                                   value="<%=product.getManufacturePhone()%>"
                                                   placeholder="Enter manufacture phone" name="manufacturePhone">
                                            <%
                                                if (errors.containsKey("phone")) {
                                            %>
                                            <p class="valid">* <%=errors.get("phone")%>
                                            </p>
                                            <%}%>
                                            <%
                                                if (errors.containsKey("phoneValid")) {
                                            %>
                                            <p class="valid">* <%=errors.get("phone")%>
                                            </p>
                                            <%}%>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--**********************************
        Content body end
    ***********************************-->


    <!--**********************************
        Footer start
    ***********************************-->
    <div class="footer">
        <div class="copyright">
            <p>Copyright © Designed &amp; Developed by <a href="#" target="_blank">Quixkit</a> 2019</p>
        </div>
    </div>
    <!--**********************************
        Footer end
    ***********************************-->

    <!--**********************************
       Support ticket button start
    ***********************************-->

    <!--**********************************
       Support ticket button end
    ***********************************-->


</div>
<!--**********************************
    Main wrapper end
***********************************-->

<!--**********************************
    Scripts
***********************************-->
<!-- Required vendors -->
<jsp:include page="/admin/includes/script.jsp"/>

</body>

</html>
