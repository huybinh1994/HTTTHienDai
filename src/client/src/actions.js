import Request from 'superagent';

const java_service_url2 = "http://172.20.10.8:8112/DoAnCuoiKy";
const java_service_url = "http://172.20.10.6:8080/DoAnCuoiKy";
const dotnet_service_url = "http://172.20.10.7:82/api";

const todoRequest = (url, method, data, option) => {
    return $.ajax({
        method: method,
        url: url,
        headers: {
            // 'Authorization': 'Basic xxxxxxxxxxxxx',
            // 'X_CSRF_TOKEN': 'xxxxxxxxxxxxxxxxxxxx',
            'Content-Type': 'application/json; charset=utf-8'
        },
        dataType: 'json',
        data: JSON.stringify(data)
    });
}

export const displayLoading = () => {
    $("#loading").show();
}

export const hideLoading = () => {
    $("#loading").hide();
}



/*************************JAVA****************************/
export const login = (username, password) => {
    return todoRequest(
        `${java_service_url}/login`,
        "POST",
        { username: username, password: password }
    );
}

export const logout = () => {
    return todoRequest(
        `${java_service_url}/logout`,
        "GET"
    )
}

export const addMerchant = (merchantInfo, token) => {
    return todoRequest(
        `${java_service_url}/master/add-merchant`,
        "POST",
        merchantInfo,
        token
    )
}

export const getMerchantValues = () => {
    return todoRequest(
        `${java_service_url}/merchant/manager`,
        "GET"
    )
}

export const getMerchantByIdAndLevel = (merchant_id) => {
    return todoRequest(
        `${java_service_url}/get-merchant-by-id-and-level/${merchant_id}/4`,
        "GET"
    )
}

export const getUser = () => {
    let user = JSON.parse(localStorage.getItem("user"));
    return user;
}

export const getStatisticNormalDate = (fromDate, toDate) => {
    return $.ajax({
        method: "GET",
        url: `${java_service_url2}/get/statistic/normal/date`,
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        data: {
            merchant: null,
            mertype: 0,
            region: null,
            code: "T0001",
            startDate: fromDate,
            endDate: toDate
        }
    });
}

export const getStatisticCardNormalDate = (formDate, toDate) => {
    return $.ajax({
        method: "GET",
        url: `${java_service_url2}/get/statistic/card/date`,
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        data: {
            merchant: null,
            mertype: 0,
            region: null,
            code: "T0001",
            startDate: formDate,
            endDate: toDate
        }
    });
}
/*************************JAVA****************************/

/*************************DOT NET*************************/
export const getMerchantList = (merchant_code, merchant_region, merchant_type) => {
    return todoRequest(
        `${dotnet_service_url}/merchant/matersearch/1/4/0/0/0`,
        "GET"
    );
}
export const getAgentListFromMaster = (master_id) => {
    return todoRequest(
        `${dotnet_service_url}/merchant/matersearch/1/2/0/0/0`,
        "GET"
    )
}
/*************************DOT NET*************************/

