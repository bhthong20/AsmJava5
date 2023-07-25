<%--
  Created by IntelliJ IDEA.
  User: thong
  Date: 04/04/2023
  Time: 9:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form class="row" action="/chi-tiet-sp/update?id=${chitietSP.id}" method="post">
    <div class="col-md-4">
        <label class="form-label">Sản phẩm</label>
        <select name="sanPham" class="form-select">
            <c:forEach items="${listSP}" var="sp">
                <option value="${sp.id}" ${chitietSP.sanPham.ten == sp.ten ? "Selected": ""}>${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label class="form-label">NSX</label>
        <select name="nhaSanXuat" class="form-select">
            <c:forEach items="${listNSX}" var="Nsx">
                <option value="${Nsx.id}" ${chitietSP.nhaSanXuat.ten == Nsx.ten ? "Selected": ""}>${Nsx.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label class="form-label">Màu sắc</label>
        <select name="mauSac" class="form-select">
            <c:forEach items="${listMS}" var="ms">
                <option value="${ms.id}" ${chitietSP.mauSac.ten == ms.ten ? "Selected": ""}>${ms.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label class="form-label">Dòng Sản phẩm</label>
        <select name="dongSP" class="form-select">
            <c:forEach items="${listDSP}" var="dsp">
                <option value="${dsp.id}" ${chitietSP.dongSP.ten == dsp.ten ? "Selected": ""}>${dsp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label class="form-label">Năm Bảo hàng</label>
        <input type="text" class="form-control" name="namBH" value="${chitietSP.namBH}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Số lượng tồn</label>
        <input type="text" class="form-control" name="soLuongTon" value="${chitietSP.soLuongTon}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Mô tả</label>
        <input type="text" class="form-control" name="moTa" value="${chitietSP.moTa}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Giá nhập</label>
        <input type="text" class="form-control" name="giaNhap" value="${chitietSP.giaNhap}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Giá bán</label>
        <input type="text" class="form-control" name="giaBan" value="${chitietSP.giaBan}">
    </div>
    <div class="col-12" style="margin-top: 10px">
        <button class="btn btn-primary" type="submit">Update</button>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
