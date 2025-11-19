Aplicação do Padrão Adapter
Este projeto implementa um sistema unificado de publicação e agendamento de conteúdo para múltiplas redes sociais utilizando o Padrão de Projeto Adapter. O objetivo é integrar APIs heterogêneas (Twitter, Instagram, LinkedIn, TikTok) em uma única interface simples e consistente, permitindo que o cliente da aplicação publique conteúdo sem conhecer os detalhes específicos de cada plataforma.

Objetivos do Projeto
Criar um sistema flexível capaz de integrar diferentes APIs de mídias sociais.

Abstrair complexidades específicas de cada plataforma: autenticação, modelos de dados, limitações de API.

Unificar o fluxo de publicação por meio de uma interface única.

Demonstrar domínio de design de software com foco em baixo acoplamento e alta coesão.

Suportar agendamento de postagens com execução futura.

Arquitetura Utilizada
A arquitetura segue três pilares:

Interface Unificada – (ISocialAdapter)

Adapters Concretos – (TwitterAdapter, InstagramAdapter, etc.)

Gerenciador de Publicações – (GerenciadorMidiaSocial)

Essa estrutura garante que o sistema se mantenha organizado, extensível e fácil de evoluir.
