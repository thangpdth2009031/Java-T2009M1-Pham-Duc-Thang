<%@ page import="java.util.HashMap" %>
<%@ page import="thang.t2009m1.t2009m1java.entity.Product" %>
<%@ page import="thang.t2009m1.t2009m1java.controller.category.ListCategory" %>
<%@ page import="thang.t2009m1.t2009m1java.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="thang.t2009m1.t2009m1java.controller.myenum.ProductStatus" %><%--
  Created by IntelliJ IDEA.
  User: DUCTHANG
  Date: 6/1/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    int action = 1;
//    String url = "/admin/products/create";
//    String title = "Create new product";
//    action = (int) request.getAttribute("action");
//    if (action == 2) {
//        url = "/admin/products/update";
//        title = "Update product";
//    }
    List<Category> categoryList = (List<Category>) request.getAttribute("categories");
    if (categoryList == null) {
        categoryList = new ArrayList<>();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        product = Product.ProductBuilder.aProduct().build();
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
                                <form method="post" action="/admin/product/create">
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label>Category</label>
                                            <select id="inputState" class="form-control">
                                                <% for (int i = 0; i < categoryList.size(); i++) { %>
                                                <option value="<%=categoryList.get(i).getId()%>"><%=categoryList.get(i).getName()%></option>
                                                <% } %>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Status</label>
                                            <select name="status" class="form-control"
                                                    data-value="<%=product.getStatus()%>">
                                                <%for (int i = 0; i < ProductStatus.values().length; i++) {%>
                                                <option value="<%=ProductStatus.values()[i].getValue()%>"><%=ProductStatus.values()[i].name()%>
                                                </option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-sm-6">
                                            <label>Product name</label>
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
                                            <label>Price</label>
                                            <input type="number" class="form-control" value="<%=product.getPrice()%>"
                                                   placeholder="Enter price"
                                                   name="price">
                                        </div>
                                    </div>
                                    <div class="form-row mt-2">
                                        <div class="col-sm-6">
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
                                    <div class="form-row  mt-2">
                                        <div class="col-sm-6">
                                            <label>Thumbnail</label>
                                            <div class="mt-2">
                                                <img id="upload_widget" class="img-preview"
                                                     style="width: 100px;height: 100%;object-fit: cover;cursor:pointer"
                                                     src="https://res.cloudinary.com/phamthanghehe/image/upload/v1654539471/opolccjzav6agkexl1uw.jpg">
                                                <input type="hidden" name="thumbnail" id="hidden-thumbnails">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>Description</label>
                                            <textarea dirname="description" class="form-control" placeholder="Enter description" name="description"
                                                      id="exampleFormControlTextarea1" rows="3"
                                                      spellcheck="false"
                                                      data-value="<%=product.getDescription()%>"></textarea>
                                            <%if (errors.containsKey("description")) {%>
                                            <p class="valid">*<%=errors.get("description")%></p>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="form-row mt-2">
                                        <div class="col-sm-12">
                                            <label>Detail</label>
                                            <input id="editor" type="text" class="form-control" value="<%=product.getDetail()%>"
                                                   placeholder="Enter detail"
                                                   name="detail">
                                        </div>
                                    </div>
                                    <div class="form-group mt-2 row">
                                        <div class="col-sm-10">
                                            <button type="submit" class="btn btn-primary">Submit</button>
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
<script src="https://cdn.ckeditor.com/ckeditor5/34.1.0/classic/ckeditor.js"></script>
<script>
    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .then( editor => {
            window.editor = editor;
        } )
        .catch( error => {
            console.error( 'There was a problem initializing the editor.', error );
        } );
</script>

<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>

<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'phamthanghehe',
            uploadPreset: 'hrn13yyl'}, (error, result) => {
            if (!error && result && result.event === "success") {
                $('#upload_widget').attr('src', result.info.secure_url);
                $('#hidden-thumbnails').val(result.info.secure_url);
            }
        }
    )

    document.getElementById("upload_widget").addEventListener("click", function(){
        myWidget.open();
    }, false);
</script>
<jsp:include page="/admin/includes/script.jsp"/>

</body>

</html>
