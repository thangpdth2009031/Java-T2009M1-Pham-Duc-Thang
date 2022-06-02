<%@ page import="java.util.HashMap" %>
<%@ page import="thang.t2009m1.t2009m1java.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: DUCTHANG
  Date: 5/30/2022
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        product = new Product();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .valid {
            color: red;
            margin: 0 0 10px 0;
            font-size: 13px
        }
    </style>
</head>
<body>

<div class="container mt-3">
    <h2>Create product</h2>
    <form action="/product" method="post">
        <div class="mb-3 mt-3">
            <label>Name product</label>
            <input type="text" class="form-control" value="<%=product.getName()%>" placeholder="Enter product name"
                   name="name">
            <%
                if (errors.containsKey("name")) {
            %>
            <p class="valid">* <%=errors.get("name")%>
            </p>
            <%}%>
        </div>
        <div class="mb-3">
            <label>Description</label>
            <input type="text" class="form-control" value="<%=product.getDescription()%>"
                   placeholder="Enter description" name="description">
            <%
                if (errors.containsKey("description")) {
            %>
            <p class="valid">* <%=errors.get("description")%>
            </p>
            <%}%>
        </div>
        <div class="mb-3">
            <label>Detail</label>
            <input type="text" class="form-control" value="<%=product.getDetail()%>" placeholder="Enter detail"
                   name="detail">
        </div>
        <div class="mb-3">
            <label>Price</label>
            <input type="number" class="form-control" value="<%=product.getPrice()%>" placeholder="Enter price"
                   name="price">
        </div>
        <div class="mb-3">
            <label>Thumbnail</label>
            <input type="text" class="form-control" value="<%=product.getThumbnail()%>" placeholder="Enter thumbnail"
                   name="thumbnail">
            <%
                if (errors.containsKey("thumbnail")) {
            %>
            <p class="valid"><%=errors.get("name")%>
            </p>
            <%}%>
        </div>
        <div class="mb-3">
            <label>Manufacture email</label>
            <input type="text" class="form-control" value="<%=product.getManufactureEmail()%>"
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
        <div class="mb-3">
            <label>Manufacture phone</label>
            <input type="text" class="form-control" value="<%=product.getManufacturePhone()%>"
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
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>