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
        <div class="row" >
          <div class="col-md-6">
            <div class="py-5 text-center pi-draggable" draggable="true">
              <div class="container">
                <div class="row">
                  <div class="mx-auto col-md-8">
                    <p class="lead text-light">As informações da transações estão ao lado.</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="py-5 pi-draggable" draggable="true">
              <div class="container">
                <div class="row">
                  <div class="card bg-light">
                    <div class="card-body p-4">
                      <div class="row">
                        <div class="col-8">
                          <h3 class="mb-0">Transação</h3>
                        </div>
                        <div class="col-4 text-right">
                          <h4 class="mb-0">Valor <b>R$ ${transaction.transactionValue}</b> </h4>
                        </div>
                      </div>
                      <p class="my-3">Tipo de transação: ${transaction.transactionType.description}</p>
                      <ul class="pl-3">
                        <li>Data de submissão: <spring:eval expression="transaction.transactionSubmitDate" /></li>
                        <li>Data de agendamento <spring:eval expression="transaction.transactionScheduleDate" /></li>
                        <li>Valor da taxa R$ ${transaction.paidTransactionTax}</li>
                        <li>Conta de Destino ${transaction.destinationAccount.id} - ${transaction.destinationAccount.user.name}</li>
                      </ul> 
                      <a class="btn btn-primary mt-3" href="/">Voltar para o Início</a> 
                    </div>
                  </div>
                </div>
              </div>
            </div>
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