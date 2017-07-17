<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>fertilizeRecord</title>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!--dateTables-->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.js"></script>
    <!--富文本编辑器-->
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
<!--查询列表-->
<table id="RecordTable" class="display uk-table uk-table-hover uk-table-striped" cellspacing="0" width="100™%">
    <thead>
    <tr>
        <th>项目序号</th>
        <th>作物名称</th>
        <th>播种环节溯源码</th>
        <th>播种时间</th>
        <th>播种量(KG)</th>
        <th>种植员</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>项目序号</th>
        <th>作物名称</th>
        <th>播种环节溯源码</th>
        <th>播种时间</th>
        <th>播种量(KG)</th>
        <th>种植员</th>
    </tr>
    </tfoot>
    <tbody>
    <script>
        $(document).ready(function () {
            var output = "";
            for(var i=0;i<20;i++){
                output+="<tr>"+
                    "<th>"+i+
                    "</th>"+
                    "<th>水稻</th>"+
                    "<th>124354354</th>"+
                    "<th>2017/09/01</th>"+
                    "<th>4.5</th>"+
                    "<th>赵二</th>"+
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
        <legend>施肥记录表单</legend>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="sowSeg_btCode">播种环节溯源码:</label>
                <input id="sowSeg_btCode" name="sowSeg_btCode" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="FertilizerName">肥料名称:</label>
                <input id="FertilizerName" name="FertilizerName" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="FertilizeTime">施肥时间:</label>
                <input id="FertilizeTime" name="FertilizeTime" type="date" placeholder="" class="datepicker input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="FertilizerNum">肥料数量:</label>
                <input id="FertilizerNum" name="FertilizerNum" type="number" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="FertilizerFrequency">施肥次数:</label>
                <input id="FertilizerFrequency" name="FertilizerFrequency" type="number" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="grower">种植员:</label>
                <input id="grower" name="grower" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Textarea -->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="Comment">备注</label>
                <div id="Comment"><p>Hello Summernote</p></div>
                <script>
                    $(document).ready(function() {
                        $('#Comment').summernote();
                    });
                </script>
            </div>
        </div>

        <div>
            <button type="submit" id="submit" name="submit" class="btn btn-info">提交</button>
        </div>

    </fieldset>
</form>

</body>
</html>