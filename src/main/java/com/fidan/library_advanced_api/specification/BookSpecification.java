package com.fidan.library_advanced_api.specification;

import com.fidan.library_advanced_api.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> hasTitle(String title) {

        return (root, query, criteriaBuilder) -> {

            if (title == null || title.isBlank()) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("title")),
                    "%" + title.toLowerCase() + "%"
            );
        };
    }

    public static Specification<Book> hasMinPrice(Double minPrice) {

        return (root, query, criteriaBuilder) -> {

            if (minPrice == null) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("price"),
                    minPrice
            );
        };
    }

    public static Specification<Book> hasAuthor(Long authorId) {

        return (root, query, criteriaBuilder) -> {

            if (authorId == null) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.equal(
                    root.get("author").get("id"),
                    authorId
            );
        };
    }

}