package com.cbt.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

public class SpringMVCFileConverter  implements Converter<String, MultipartFile>{

	public SpringMVCFileConverter() {
        super();
    }

    @Override
    public MultipartFile convert(String source) {
        return null;
    }

}
