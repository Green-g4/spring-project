  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">게시글 등록</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">게시글 등록 페이지</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <form action="/member/register" method="POST" role="form">
          <div class="form-group">
            <label for="member_id">제목</label>
            <input type="text" class="form-control" name="member_id" />
          </div>
          <div class="form-group">
            <label for="member_password">내용</label>
            <textarea name="member_password" id="member_password" rows="3" class="form-control"></textarea>
          </div>
          <div class="form-group">
            <label for="member_name">저자</label>
            <input type="member_name" class="form-control" name="member_name" />
          </div>
          <div class="form-group">
            <label for="member_address">저자</label>
            <input type="member_address" class="form-control" name="member_address" />
          </div>
          <div class="form-group">
            <label for="member_phonenumber">저자</label>
            <input type="member_phonenumber" class="form-control" name="member_phonenumber" />
          </div>
          <div class="form-group">
            <label for="member_gender">저자</label>
            <input type="member_gender" class="form-control" name="member_gender" />
          </div>
          <div class="form-group">
            <label for="member_role">저자</label>
            <input type="member_role" class="form-control" name="member_role" />
          </div>
          <button class="btn btn-default" type="submit">등록</button>
          <button class="btn btn-default" type="reset">초기화</button>
        </form>
      </div>
      <!-- /.panel-boby -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!--  /.row -->
