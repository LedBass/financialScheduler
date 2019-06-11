<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
    <title>Financial Scheduler</title>
  </head>
  <body style="background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75));  background-position: center center, center center;  background-size: 100%, 100%;">
    <div class="py-5">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <div class="py-5 text-center text-white h-100 align-items-center d-flex">
              <div class="container py-5">
                <div class="row">
                  <div class="mx-auto col-lg-8 col-md-10">
                    <h1 class="display-3 mb-4" >Bem vindo ${user.name}</h1> <h5>Saldo atual: ${account.balance}</h5>
                    <a href="/principal/transactions/new/${user.id}" class="btn btn-lg btn-primary mx-1">Criar uma nova transação.</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <c:choose>
            <c:when test="${not empty transactions}">
              <div class="list-group pi-draggable" draggable="true">
              <c:forEach items="${transactions}" var="transaction">
                <a href="/principal/transactions/details/${transaction.id}" class="list-group-item list-group-item-action active">Conta destino: ${transaction.destinationAccount.id} - Valor: ${transaction.transactionValue}</a>
              </c:forEach>
              </div>
            </c:when>
            <c:otherwise>
            	<p class="text-light" >Não há transações a serem listadas.</p>
            </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
    </div>
    <div class="container text-center text-white h-100 align-items-center" style="background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75));  background-position: center center, center center;  background-size: 100%, 100%;">
      <div style="position: fixed; botton:0; right: 0;">
        <a class="m-5 btn btn-outline-warning" href="/">Início</a>
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>