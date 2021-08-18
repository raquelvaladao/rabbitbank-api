package br.com.rabbitbank.rabbitbank.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Page;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseResource<T> {
    protected ResponseEntity<T> answerCreatedItem(T object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    protected ResponseEntity<T> answerCreatedItemWithURI(T object, UriComponentsBuilder uriBuilder, String path,
                                                          String code) {
        URI uri = uriBuilder.path(path).buildAndExpand(code).toUri();
        return ResponseEntity.created(uri).body(object);
    }

    protected ResponseEntity<T> answerNotFoundItem() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    protected ResponseEntity<T> answerSuccess() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    protected ResponseEntity<T> answerSuccessWithItem(T object) {
        return ResponseEntity.status(HttpStatus.OK).body(object);
    }

    protected ResponseEntity<List<T>> answerEmptyList() {
        List<T> emptyList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(emptyList);
    }

    protected ResponseEntity<List<T>> answerListOfItems(List<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    protected ResponseEntity<T> answerBadRequestCall() {
        return ResponseEntity.badRequest().build();
    }

    protected ResponseEntity<Page<T>> answerPaginatedListOfItems(Page<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

}
