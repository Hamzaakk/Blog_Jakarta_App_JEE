<div class="col">
    <div class="card">
        <img src="https://media.istockphoto.com/id/1334591614/photo/man-using-digital-tablet-online-connect-to-internet-banking-currency-exchange-online-shopping.jpg?s=1024x1024&w=is&k=20&c=ho97hTtpbzO2oM5e8EDdGf8a6ZLRZr94gWxBAnRMzLk=" class="card-img-top" alt="Hollywood Sign on The Hill">
        <div class="card-body">
            <h5 class="card-title"><%=post.getTitle()%></h5>
            <p class="card-text" id="truncatedContent">
                <!-- Truncated content will be inserted here -->
            </p>
            <div class="d-flex">
                <form action="delete.php" method="get">
                    <button type="submit" class="btn btn-danger" data-mdb-ripple-init>Remove</button>
                    <input type="hidden" name="id" value="<%=post.getId()%>">
                </form>

                <form action="update.php" method="get" style="padding-left: 10px">
                    <button type="submit" class="btn btn-info" data-mdb-ripple-init>Edit</button>
                    <input type="hidden" name="id" value="<%=post.getId()%>">
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        // Max length of the truncated content
        var maxLength = 100;

        // Get the full content
        var fullContent = "<%=post.getContent()%>";

        // Truncate the content
        var truncatedContent = fullContent.substring(0, maxLength);

        // Display the truncated content
        document.getElementById('truncatedContent').textContent = truncatedContent;
    });
</script>
