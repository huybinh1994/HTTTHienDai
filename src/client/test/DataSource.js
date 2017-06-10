export const merchantTypes = [
    {value: "1", name: "Quần Áo"},
    {value: "2", name: "Giày Dép"},
    {value: "3", name: "Thiết Bị Điện Tử"},
    {value: "4", name: "Thiết Bị Công Nghệ"}
]

export const reportTypes = [
    {value: "1", name: "Thống Kê Theo Tháng"},
    {value: "2", name: "Thông Kê Theo Quý"},
    {value: "3", name: "Thống Kê Theo Năm"}
]

export const locations = [
    {
        "code": "b",
        "name": "Miền Bắc",
        "subs": [
            {
                "code": "1",
                "name": "Thành phố Hà Nội",
                "subs": [
                    {
                        "code": "001", "name": "Quận Ba Đình",
                        "subs": [
                            { "code": "00001", "name": "Phường Phúc Xá" },
                            { "code": "00004", "name": "Phường Trúc Bạch" },
                            { "code": "00006", "name": "Phường Vĩnh Phúc" },
                            { "code": "00007", "name": "Phường Cống Vị" },
                            { "code": "00008", "name": "Phường Liễu Giai" },
                            { "code": "00010", "name": "Phường Nguyễn Trung Trực" },
                            { "code": "00013", "name": "Phường Quán Thánh" },
                            { "code": "00016", "name": "Phường Ngọc Hà" },
                            { "code": "00019", "name": "Phường Điện Biên" },
                            { "code": "00022", "name": "Phường Đội Cấn" },
                            { "code": "00025", "name": "Phường Ngọc Khánh" },
                            { "code": "00028", "name": "Phường Kim Mã" },
                            { "code": "00031", "name": "Phường Giảng Võ" },
                            { "code": "00034", "name": "Phường Thành Công" },
                        ]
                    },
                    {
                        "code": "002", "name": "Quận Hoàng Kiếm",
                        "subs": [
                            { "code": "00037", "name": "Phường Phúc Tân" },
                            { "code": "00040", "name": "Phường Đồng Xuân" },
                            { "code": "00043", "name": "Phường Hàng Mã" },
                            { "code": "00046", "name": "Phường Hàng Buồm" },
                            { "code": "00049", "name": "Phường Hàng Đào" },
                            { "code": "00052", "name": "Phường Hàng Bồ" },
                            { "code": "00055", "name": "Phường Cửa Đông" },
                            { "code": "00058", "name": "Phường Lý Thái Tổ" },
                            { "code": "00061", "name": "Phường Hàng Bạc" },
                            { "code": "00064", "name": "Phường Hàng Gai" },
                            { "code": "00067", "name": "Phường Chương Dương Độ" },
                            { "code": "00070", "name": "Phường Hàng Trống" },
                            { "code": "00073", "name": "Phường Cửa Nam" },
                            { "code": "00076", "name": "Phường Hàng Bông" },
                            { "code": "00079", "name": "Phường Tràng Tiền" },
                            { "code": "00082", "name": "Phường Trần Hưng Đạo" },
                            { "code": "00085", "name": "Phường Phan Chu Trinh" },
                            { "code": "00088", "name": "Phường Hàng Bài" },
                        ]
                    },
                ],
            },
        ]
    },
    {
        "code": "t",
        "name": "Miền Trung",
        "subs" :[]
    },
    {
        "code": "n",
        "name": "Miền Nam",
        "subs": [
            {
                "code": "79",
                "name": "Thành phố Hồ Chí Minh",
                "subs": [
                    {
                        "code": "760",
                        "name": "Quận 1",
                        "subs": [
                            { "code": "26734", "name": "Phường Tân Định" },
                            { "code": "26737", "name": "Phường Đa Kao" },
                            { "code": "26740", "name": "Phường Bến Nghé" },
                            { "code": "26743", "name": "Phường Bến Thành" },
                            { "code": "26746", "name": "Phường Nguyễn Thái Bình" },
                            { "code": "26749", "name": "Phường Phạm Ngũ Lão" },
                            { "code": "26752", "name": "Phường Cầu Ông Lãnh" },
                            { "code": "26755", "name": "Phường Cô Giang" },
                            { "code": "26758", "name": "Phường Nguyễn Cư Trinh" },
                            { "code": "26761", "name": "Phường Cầu Kho" }
                        ]
                    },
                    {
                        "code": "769",
                        "name": "Quận 2",
                        "subs": [
                            { "code": "27088", "name": "Phường Thảo Điền" },
                            { "code": "27091", "name": "Phường An Phú" },
                            { "code": "27094", "name": "Phường Bình An" },
                            { "code": "27097", "name": "Phường Bình Trưng Đông" },
                            { "code": "27100", "name": "Phường Bình Trưng Tây" },
                            { "code": "27103", "name": "Phường Bình Khánh" },
                            { "code": "27106", "name": "Phường An Khánh" },
                            { "code": "27109", "name": "Phường Cát Lái" },
                            { "code": "27112", "name": "Phường Thạnh Mỹ Lợi" },
                            { "code": "27115", "name": "Phường An Lợi Đông" },
                            { "code": "27118", "name": "Phường Thủ Thiêm" }
                        ]
                    },
                ]
            }
        ]
    }
];

export const Messages = {
    "required": "Vui lòng không bỏ trống thông tin này.",
    "number": "Vui lòng điền thông tin là số.",
    "email": "Vui lòng điền vào một email hợp lệ."
}