# ajax传JSON

```javascript
$.ajax({
                            url: basePath + 'frontend/del'
                            , type: "post"
                            , async: true
                            , contentType: "application/json"
                            , dataType: 'json'
                            , data: JSON.stringify(ids)
                            , success: function (data) {
                                layer.closeAll('loading');
                                if (data.success) {
                                    layer.msg(data.msg, {icon: 1});
                                    table.reload('frontend-user-table');
                                } else {
                                    layer.msg(data.msg, {icon: 2});
                                }
                            }
                        });
```

