-- View: public.vw_livros

-- DROP VIEW public.vw_livros;

CREATE OR REPLACE VIEW public.vw_livros
 AS
 SELECT l.id,
    l.titulo,
    l.editora,
    l.edicao,
    l.ano_publicacao,
    ( SELECT array_to_string(array_agg(DISTINCT au.nome), ', '::text) AS array_to_string
           FROM autor au
             JOIN livro_autor lau ON au.id = lau.autores_id
          WHERE lau.livros_id = l.id) AS autores,
    ( SELECT array_to_string(array_agg(DISTINCT ass.descricao), ', '::text) AS array_to_string
           FROM assunto ass
             JOIN livro_assunto las ON ass.id = las.assuntos_id
          WHERE las.livros_id = l.id) AS assuntos,
    l.valor
   FROM livro l
  ORDER BY l.id;

ALTER TABLE public.vw_livros
    OWNER TO postgres;