# 封装MeterSphere的插件demo，可以直接拿来快速封装。

## 注意事项：
1. 前端通过https://www.form-create.com/designer/?fr=home 这个地址生成对应页面，点击表单生成器右上角的 `生成JSON` 按钮，将内容保存到 src\main\resources\json\ui_demo.json(可以改成自己插件的名字比如ui_shengli.json) 文件中；点击右上角的 `生成Options` 按钮，将内容保存到 src\main\resources\json\ui_form.json 文件中。对于没有默认值的字段，可以手动编辑下 json 文件增加一个空的默认值，避免出现空指针异常。