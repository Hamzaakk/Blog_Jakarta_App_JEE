<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.1.0/mdb.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <title>Document</title>

</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary">
    <div class="container-fluid">
        <button data-mdb-collapse-init class="navbar-toggler" type="button"
                data-mdb-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <a class="navbar-brand mt-2 mt-lg-0" href="#">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAeFBMVEUAAAD///+3t7f8/Pzs7Oz39/d6enpPT0/IyMjy8vL19fWtra04ODhxcXHU1NSqqqpeXl6Xl5fc3NwJCQl/f38WFhbm5uaPj4/AwMArKyuFhYVNTU1kZGQREREyMjJFRUUiIiKgoKBoaGgnJyc9PT2MjIwcHBxWVlbgTdlVAAAEsUlEQVR4nO3c6XqqMBAGYHDD3dbj1rpUu9j7v8NTCAhhnYQZofZ7f/LEmGHJRoLjAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQJtdp95hNpsd9qdj00Xh9zHoLEdubDSfDP41XSg+h04yuFhv4TVdNA6nST83vDDIy9Usu9VuMx7NF98yhbVwmJeEp+zeyLkdO/GpWQmWmm6/rIzPNzzRsltpv1qeRctOsR6S4vNNKPl10r96ko6gwis5vh/jQ2V+Off7IC/ddL67T2NU/QDqOhX55d4QOVfx2nXdjUhEOq+sAs3XeynLcJL/o2kmYXAmLmKBRQbG8flKmoD3otOSTngKDnclg/NdrAIseK5868KfpG/u8Fq/yga4sAzQdYsauZJaOdUtGqujc9EAL9YBFl3Fp5Jf6LWKFx1eCwb4XCNA133Py3JT9gvthrzdPoU3fH2zWgG6bk4frjzLfjLprRNV1fjY+6wZoF5gpfQS6g/v7WCmkmWTP04ykakkyp5CX+JJ9OKjUqPPTN/RwnMqz8rubdyObuODQp3WqtNNo3duitvCyC7vBKfPExPzvlqepZbntvoHt7SJ0ZpMVXNhCTBV1VfUM1r6xBleZotX35UpQK0+fSGkH0aJE8dGEhFyVDNK4iH6IiSPOtpe8qBAgGyXULuIpImCsOLUhjSf/BEWDOGsxF2xLiX5QqXVOowz/ghJZSG6dUneSMnDakV7TL7YA1wV/b2VaFBEaCt8KrF2R/OP800nZspFzdmOllydEG3ycldcVDvVXQ8jUV3ToyVXz63WKR4Wl9WO0eQhQXibEh9uNeGqdanYm3z69C+Nqh6pg7F59nSwj5/GzBGqS1A0x5YWhHPWDnHPt52YAwyrR/KUiJ94Khohb1vhCx5E8rTd2cm0ncwRcnZolKB6JD/deyfVLWWfbuOuaMLqkfZ6zlUDqNT4u/QtgTnCKM7Q0Chb/4of9EPMXW/OTqkSTDCRJ7a2TmbWkf5uuaEIe0bZ+r3Q1PugPWuA5/z/rSMYpJNTL6QjpMw1GOrXjZB3KYtAhN2Hj7Bl1/Dxn0N6UchaVpf+gfawDX2a1FAru06jlqb7pf7coWy/1H51QhGzsYVfccqOLfjHh99GJ+7sSI8P+RvEINsWjfEff56m4bk2dT5k59q450vDl/Mtmi9tds5bvYaRnfNu9r2F6qHJvrf4A++e2vb+UGAB5uO/A2YcI3K8x2fueAf41mJs40zbtBaD7yK2dj2Nc2GKsLVromTWtRE637e04uva0m8OLOnboI6V6XPXJm7TZWPSyPrSeCmp/PpScj+yBNMaYakAU6NQC61f500esxYxXquvNQt3WKt///0W2j6bS3RUcL9FS/bMyG5BtA+Rbd+TUHt/Y3uj/pq9a7Zbgzj2H4Z1uWRwyv7R95A6ze0DPt5pH7BjOL3Yt9rLnTuMn86H9/rixpE4T+b+1v34PzzRbyp8yBae6Jv1uxjXxHcxRDstRk6Tsnc2I9Nvm7zuNv3RvG2ffXkq+j7NpGUFreO8euhvDEXWU+89+E7U9AG/EwUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJ/wFTZUNtMEP4sAAAAABJRU5ErkJggg==" height="25" alt="MDB Logo" loading="lazy" />Geegs
            </a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">My Posts</a>
                </li>

            </ul>
        </div>
        <div class="d-flex align-items-center">
            <div class="dropdown">
                <a data-mdb-dropdown-init class="text-reset me-3 dropdown-toggle hidden-arrow" href="#"
                   id="navbarDropdownMenuLink" role="button" aria-expanded="false">
                    <i class="fas fa-bell"></i>
                    <span class="badge rounded-pill badge-notification bg-danger">1</span>
                </a>

            </div>
            <div class="dropdown">
                <a data-mdb-dropdown-init class="dropdown-toggle d-flex align-items-center hidden-arrow" href="#"
                   id="navbarDropdownMenuAvatar" role="button" aria-expanded="false">
                    <img src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp" class="rounded-circle" height="25"
                         alt="Black and White Portrait of a Man" loading="lazy" />
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuAvatar">
                    <li>
                        <a class="dropdown-item" href="#">My profile</a>
                    </li>

                    <li>
                        <a class="dropdown-item" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!-- Navbar -->

