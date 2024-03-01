<%@ page import="com.example.blog_app_jakarta_ee.metier.models.Post" %>
<%@ page import="java.util.List" %>
<%@include file="includes/header.jsp"%>
<% List<Post> posts = (List<Post>) request.getAttribute("allPosts"); %>

<header>
    <!-- Background image -->
    <div
            class="p-5 text-center bg-image"
            style="
        background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/041.webp');
        height: 400px;
      "
    >
        <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
            <div class="d-flex justify-content-center align-items-center h-100">
                <div class="text-white">
                    <h1 class="mb-3">GEEGKS</h1>
                    <a data-mdb-ripple-init class="btn btn-outline-light btn-lg" href="/Blog_App_Jakarta_EE_war/addNewPost" role="button"
                    >Call to action</a
                    >
                </div>
            </div>
        </div>
    </div>
    <!-- Background image -->
</header>
<div class="container p-3 d-flex ">
    <div class="input-group p-3 justify-content-end ">
        <div class="form-outline " data-mdb-input-init style="width: 200px;">
            <input type="search" id="form1" class="form-control" />
            <label class="form-label" for="form1">Search</label>
        </div>
        <button type="button" class="btn btn-primary " data-mdb-ripple-init>
            <i class="fas fa-search"></i>
        </button>
    </div>
</div>
<div class="container p-3">
    <div class="row row-cols-1 row-cols-md-4 g-4">
      <%for(Post post:posts){ %>
        <%@include file="components/geegCard.jsp" %>
        <%}%>
    </div>
</div>

<%@include file="includes/footer.jsp"%>