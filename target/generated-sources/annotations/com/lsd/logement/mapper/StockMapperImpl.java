package com.lsd.logement.mapper;

import com.lsd.logement.dto.StockDTO;
import com.lsd.logement.entity.Stock.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T13:58:05-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class StockMapperImpl implements StockMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public StockDTO asDTO(Stock entity) {
        if ( entity == null ) {
            return null;
        }

        StockDTO stockDTO = new StockDTO();

        stockDTO.setId( entity.getId() );
        stockDTO.setArticle( entity.getArticle() );
        stockDTO.setQte( entity.getQte() );
        stockDTO.setCreatedAt( entity.getCreatedAt() );
        stockDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );

        return stockDTO;
    }

    @Override
    public List<Stock> asEntityList(List<StockDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Stock> list = new ArrayList<Stock>( dtoList.size() );
        for ( StockDTO stockDTO : dtoList ) {
            list.add( asEntity( stockDTO ) );
        }

        return list;
    }

    @Override
    public List<StockDTO> asDTOList(List<Stock> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StockDTO> list = new ArrayList<StockDTO>( entityList.size() );
        for ( Stock stock : entityList ) {
            list.add( asDTO( stock ) );
        }

        return list;
    }

    @Override
    public Stock asEntity(StockDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Stock stock = referenceMapper.resolve( dto, Stock.class );

        stock.setId( dto.getId() );
        stock.setArticle( dto.getArticle() );
        stock.setQte( dto.getQte() );
        stock.setCreatedAt( dto.getCreatedAt() );
        stock.setLastUpdatedAt( dto.getLastUpdatedAt() );

        return stock;
    }
}
