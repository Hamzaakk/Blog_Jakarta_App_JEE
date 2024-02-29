<%@include file="includes/header.jsp"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container w-75 my-5" style="height: 578px">

    <div class="alert alert-primary" role="alert">
        A simple primary alert—check it out!
    </div>
<form class="my-5" action="addNewPost.php" method="POST">
    <!-- 2 column grid layout with text inputs for the first and last names -->
    <div class="row mb-4">
        <div class="col">
            <div data-mdb-input-init class="form-outline">
                <input type="text" id="form6Example1" class="form-control" name="title" />
                <label class="form-label" for="form6Example1">Title</label>
            </div>
        </div>
        <div class="col">
            <div data-mdb-input-init class="form-outline">
                <input type="file" id="form6Example2" class="form-control" name="image"/>
            </div>
        </div>
    </div>

    <!-- Message input -->
    <div data-mdb-input-init class="form-outline mb-4">
        <textarea class="form-control" id="form6Example7" rows="4" name="details"></textarea>
        <label class="form-label" for="form6Example7">détails</label>
    </div>

    <!-- Submit button -->
    <button data-mdb-ripple-init type="submit" class="btn btn-primary btn-block mb-4">ADD POST</button>
</form>
</div>

<%@include file="includes/footer.jsp"%>