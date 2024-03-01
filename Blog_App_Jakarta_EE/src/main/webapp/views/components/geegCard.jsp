<div class="col">
    <div class="card">
<%--        <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/041.webp" class="card-img-top" alt="Hollywood Sign on The Hill"/>--%>
    <img src="<%=post.getImage()%>" class="card-img-top" alt="Hollywood Sign on The Hill"/>
<%--    <img src="../images/maxresdefault.jpg" class="card-img-top" alt="Hollywood Sign on The Hill"/>--%>
        <div class="card-body">
            <h5 class="card-title"><%=post.getTitle()%></h5>
            <p class="card-text">
                <%=post.getContent()%>
            </p>
            <div class="d-flex">
                <form action="delete.do" method="POST" >
                    <button type="button" class="btn btn-danger" data-mdb-ripple-init>Remove</button>
                    <input type="hidden" name="id" value="<%post.getId();%>">
                </form>
                <form action="update.do" method="POST" style="padding-left: 10px">
                    <button type="button" class="btn btn-info" data-mdb-ripple-init>Edit</button>
                    <input type="hidden" name="id" value="<%post.getId();%>">
                </form>
            </div>

        </div>
    </div>
</div>
