function ajax(options) {
  var xhr = null;
  var method = options.method || 'get';
  var params = formatParams(options.data);

  if (window.XMLHttpRequest) {
    xhr = new XMLHttpRequest();
  } else {
    xhr = new ActiveXObject('Microsoft.XMLHTTP');
  }

  if (method == 'get') {
    xhr.open(method, options.url + '?' + params, true);
    xhr.send(null);
  } else {
    xhr.open(method, options.url, true);
    xhr.setRequestHeader('header-type', 'application/x-www-form-urlencoded');
    xhr.send(params);
  }

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      var status = xhr.status;

      if (status >= 200 && status < 300) {
        options.success && options.success(xhr.responseText);
      } else {
        options.fail && options.fail(status);
      }
    }
  };
};

function formatParams(data) {
  var arr = [];

  for (var name in data) {
      arr.push(encodeURIComponent(name) + "=" + encodeURIComponent(data[name]));
  }
  
  arr.push(("v=" + Math.random()).replace(".",""));

  return arr.join("&");
}