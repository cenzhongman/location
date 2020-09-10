# location
中国行政区划分 GB/T 2260

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
        }
    ]
}
```
            
