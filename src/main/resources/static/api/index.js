const METHOD = {
    PUT() {
        return {
            method: "PUT"
        };
    },
    DELETE() {
        return {
            method: "DELETE"
        };
    },
    POST(data) {
        return {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        };
    }
};

const api = (() => {
    const request = (uri, config) => fetch(uri, config).then(data => data.json());

    const station = {
        get() {
            return request(`/api/stations`);
        },
        create(data) {
            return request(`/api/stations`, METHOD.POST(data));
        },
        update(data, id) {
            return request(`/api/stations/${id}`, METHOD.PUT(data));
        },
        delete(id) {
            return request(`/api/stations/${id}`, METHOD.DELETE);
        }
    };

    const line = {
        get() {
            return request(`/api/lines`);
        },
        create(data) {
            return request(`/api/lines`, METHOD.POST(data));
        },
        update(data, id) {
            return request(`/api/line/${id}`, METHOD.PUT(data));
        },
        delete(id) {
            return request(`/api/line/${id}`, METHOD.DELETE);
        }
    };

    return {
        line
    };
})();

export default api;
