package zielinskin.h2example.logic.converter;

interface RelatedChildConverter<P, S, R> {
    R convert(P parent, S source);
}
