package com.lsd.logement.mapper;

import com.lsd.logement.dto.ArticleDTO;
import com.lsd.logement.entity.Stock.Article;
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
public class ArticleMapperImpl implements ArticleMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public ArticleDTO asDTO(Article entity) {
        if ( entity == null ) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setId( entity.getId() );
        articleDTO.setDesignation( entity.getDesignation() );
        articleDTO.setCreatedAt( entity.getCreatedAt() );
        articleDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );

        return articleDTO;
    }

    @Override
    public List<Article> asEntityList(List<ArticleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Article> list = new ArrayList<Article>( dtoList.size() );
        for ( ArticleDTO articleDTO : dtoList ) {
            list.add( asEntity( articleDTO ) );
        }

        return list;
    }

    @Override
    public List<ArticleDTO> asDTOList(List<Article> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ArticleDTO> list = new ArrayList<ArticleDTO>( entityList.size() );
        for ( Article article : entityList ) {
            list.add( asDTO( article ) );
        }

        return list;
    }

    @Override
    public Article asEntity(ArticleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Article article = referenceMapper.resolve( dto, Article.class );

        article.setId( dto.getId() );
        article.setDesignation( dto.getDesignation() );
        article.setCreatedAt( dto.getCreatedAt() );
        article.setLastUpdatedAt( dto.getLastUpdatedAt() );

        return article;
    }
}
