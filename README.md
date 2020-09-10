# 中国行政区划分

[GB/T 2260](http://www.gb688.cn/bzgk/gb/newGbInfo?hcno=C9C488FD717AFDCD52157F41C3302C6D)

* location.json

```json
{
  "110000":"北京市",
  "110101":"东城区",
  "110102":"西城区",
  "130000":"河北省",
  "130100":"石家庄市"
}
```

* location-tree-1.json

中国-北京市-东城区  
中国-河北省-石家庄市-长安区  

```json
{
    "code": 100000,
    "name": "中国",
    "level": 0,
    "locations": [
        {
            "code": 110000,
            "name": "北京市",
            "level": 1,
            "locations": [
                {
                    "code": 110101,
                    "name": "东城区",
                    "level": 3,
                    "locations": []
                }
            ]
        }
    ]
}
```

* location-tree-2.json

中国-北京市-北京市-东城区  
中国-河北省-石家庄市-长安区  

```json
{
    "code": 100000,
    "name": "中国",
    "level": 0,
    "locations": [
        {
            "code": 110000,
            "name": "北京市",
            "level": 1,
            "locations": [
                {
                    "code": 110000,
                    "name": "北京市",
                    "level": 2,
                    "locations": [
                        {
                            "code": 110101,
                            "name": "东城区",
                            "level": 3,
                            "locations": []
                        }
                    ]
                }
            ]
        }
    ]
}
```

## 参考

[中华人民共和国-全国行政区划信息查询平台](http://xzqh.mca.gov.cn/map)   
[百度地图API](http://api.map.baidu.com/lbsapi/getpoint/)  
[数据源-中国行政区划信息](https://github.com/mumuy/data_location)  
