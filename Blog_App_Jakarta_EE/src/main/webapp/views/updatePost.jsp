<%@ page import="com.example.blog_app_jakarta_ee.metier.models.Post" %>
<%@include file="includes/header.jsp"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Post postU = (Post) request.getAttribute("post");%>

<div class="container w-75 my-5" style="height: 578px">

    <div class="alert alert-primary" role="alert">
        A simple primary alert—check it out!
    </div>
<form class="my-5" action="edit.php" method="POST" enctype="multipart/form-data">
    <!-- 2 column grid layout with text inputs for the first and last names -->
    <div class="row mb-4">
        <div class="col">
            <div data-mdb-input-init class="form-outline">
                <input type="text" id="form6Example1" class="form-control" name="title" value="<%=postU.getTitle()%>"/>
                <input type="hidden" id="id" class="form-control" name="id" value="<%=postU.getId()%>"/>
                <input type="hidden" id="hi" class="form-control" name="id_u" value="<%=postU.getUserID()%>"/>
                <label class="form-label" for="form6Example1">Title</label>
            </div>
        </div>
        <div class="col">
            <div data-mdb-input-init class="form-outline">
                <input type="file" id="form6Example2" name="image" class="form-control" />
            </div>
        </div>
    </div>

    <!-- Message input -->
    <div data-mdb-input-init class="form-outline mb-4">
        <textarea class="form-control" id="form6Example7" rows="4" name="details"  ><%=postU.getContent()%></textarea>
        <label class="form-label" for="form6Example7">détails</label>
    </div>

    <!-- Submit button -->
    <button data-mdb-ripple-init type="submit" class="btn btn-primary btn-block mb-4">UPDATE POST</button>
</form>
</div>

<%@include file="includes/footer.jsp"%>