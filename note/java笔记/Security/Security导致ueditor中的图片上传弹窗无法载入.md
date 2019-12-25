# Security导致ueditor中的图片上传弹窗无法载入

springSecurty将x-frame-options默认为 deny，无法打开框架，而这个编辑器需要打开框架，所以报错了。x-frame-options设置一下为sameOrigin就行。

![ac5e4359dd8a055488651f53e1dbf58](C:\Users\ybq\AppData\Local\Temp\WeChat Files\ac5e4359dd8a055488651f53e1dbf58.png)