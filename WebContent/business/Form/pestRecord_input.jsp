<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>pestRecord</title>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!--dateTables-->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.js"></script>
    <!--å¯ææ¬ç¼è¾å¨-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.js"></script>
    <!--jquery-ui-->
    <link href="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function() {
            $( ".datepicker" ).datepicker();
        });
    </script>

    <link rel="stylesheet" href="css/Form.css">
</head>
<body>
<!--æ¥è¯¢åè¡¨-->
<table id="RecordTable" class="display uk-table uk-table-hover uk-table-striped" cellspacing="0" width="100â¢%">
    <thead>
    <tr>
        <th>é¡¹ç®åºå·</th>
        <th>ä½ç©åç§°</th>
        <th>æ­ç§ç¯èæº¯æºç </th>
        <th>æ½è¥æ¶é´</th>
        <th>æ½è¥æ¬¡æ°</th>
        <th>ç§æ¤å</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>é¡¹ç®åºå·</th>
        <th>ä½ç©åç§°</th>
        <th>æ­ç§ç¯èæº¯æºç </th>
        <th>æ½è¥æ¶é´</th>
        <th>æ½è¥æ¬¡æ°</th>
        <th>ç§æ¤å</th>
    </tr>
    </tfoot>
    <tbody>
    <script>
        $(document).ready(function () {
            var output = "";
            for(var i=0;i<200;i++){
                output+="<tr>"+
                    "<th>"+i+
                    "</th>"+
                    "<th>æ°´ç¨»</th>"+
                    "<th>124354354</th>"+
                    "<th>2019/09/13</th>"+
                    "<th>3</th>"+
                    "<th>èµµäº</th>"+
                    "</tr>";
            }
            $("#RecordTable").append(output);
        })
    </script>
    </tbody>
</table>

<script>
    $(document).ready(function() {
        $('#RecordTable').DataTable();
    } );
</script>
<form class="form-horizontal" >
    <fieldset>

        <!-- Form Name -->
        <legend>çè«å®³é²æ²»è®°å½è¡¨å</legend>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="sowSeg_btCode">æ­ç§ç¯èæº¯æºç :</label>
                <input id="sowSeg_btCode" name="sowSeg_btCode" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="PestsType">çè«å®³ç±»å:</label>
                <input id="PestsType" name="PestsType" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="SprayTime">å·è¯æ¶é´:</label>
                <input id="SprayTime" name="SprayTime" type="date" placeholder="" class="datepicker input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="MedicationName">éç¨è¯ç©:</label>
                <input id="MedicationName" name="MedicationName" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="MedicationRatio">è¯ç©éç½®æ¯ä¾:</label>
                <input id="MedicationRatio" name="MedicationRatio" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="MedicationDosage">è¯åç¨é</label>
                <input id="MedicationDosage" name="MedicationDosage" type="number" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="result">é²æ²»ææ:</label>
                <input id="result" name="result" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="grower">ç§æ¤å:</label>
                <input id="grower" name="grower" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Textarea -->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="Comment">å¤æ³¨</label>
                <div id="Comment"><p>Hello Summernote</p></div>
                <script>
                    $(document).ready(function() {
                        $('#Comment').summernote();
                    });
                </script>
            </div>
        </div>

        <div>
            <button type="submit" id="submit" name="submit" class="btn btn-info">æäº¤</button>
        </div>

    </fieldset>
</form>

</body>
</html>