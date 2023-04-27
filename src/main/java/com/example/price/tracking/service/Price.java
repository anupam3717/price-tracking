package com.example.price.tracking.service;

import java.io.IOException;

public interface Price {
    public String getLatestPrice() throws IOException;
}
